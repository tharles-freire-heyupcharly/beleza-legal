package com.mackenzie.belezalegal




import android.R.attr
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow.LayoutParams
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.itextpdf.text.BaseColor
import com.itextpdf.text.Document
import com.itextpdf.text.DocumentException
import com.itextpdf.text.Font
import com.itextpdf.text.PageSize
import com.itextpdf.text.Paragraph
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import com.mackenzie.belezalegal.databinding.FragmentSelfdiagnosisBinding
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SelfDiagnosisFragment : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()
    private var _binding: FragmentSelfdiagnosisBinding? = null
    private val column0Layout = LayoutParams(0, LayoutParams.WRAP_CONTENT, 4F)
    private val column1Layout = LayoutParams(0, LayoutParams.WRAP_CONTENT, 1F)
    private val column2Layout = LayoutParams(0, LayoutParams.WRAP_CONTENT, 1F)
    private var tableRowParams = TableLayout.LayoutParams(
        TableLayout.LayoutParams.MATCH_PARENT,
        TableLayout.LayoutParams.WRAP_CONTENT)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelfdiagnosisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFields()

        binding.saveToPdf.setOnClickListener { view ->
            createPdf()
            Snackbar.make(view, "Download PDF", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

        binding.buttonNext.setOnClickListener {
            //viewModel.saveToSheet(context)
            findNavController().navigate(R.id.action_selfDiagnosisFragment_to_handoutFragment2)
        }
    }

    override fun onResume() {
        super.onResume()
        setFields()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setFields(){
        binding.risk8.setText(riskScore(viewModel.weight8.value.toString()))
        binding.risk9.setText(riskScore(viewModel.weight9.value.toString()))
        //binding.risk10.setText(riskScore(viewModel.weight10.value.toString()))
        binding.risk11.setText(riskScore(viewModel.weight11.value.toString()))
        binding.risk12.setText(riskScore(viewModel.weight12.value.toString()))
        binding.risk13.setText(riskScore(viewModel.weight13.value.toString()))
        binding.risk14.setText(riskScore(viewModel.weight14.value.toString()))
        binding.risk15.setText(riskScore(viewModel.weight15.value.toString()))
        binding.risk16.setText(riskScore(viewModel.weight16.value.toString()))
        binding.risk17.setText(riskScore(viewModel.weight17.value.toString()))
        binding.risk18.setText(riskScore(viewModel.weight18.value.toString()))
        binding.risk19.setText(riskScore(viewModel.weight19.value.toString()))
        binding.risk20.setText(riskScore(viewModel.weight20.value.toString()))
        binding.risk21.setText(riskScore(viewModel.weight21.value.toString()))
        binding.risk22.setText(riskScore(viewModel.weight22.value.toString()))
        binding.risk23.setText(riskScore(viewModel.weight23.value.toString()))
        binding.risk24.setText(riskScore(viewModel.weight24.value.toString()))
        binding.risk25.setText(riskScore(viewModel.weight25.value.toString()))
        binding.risk26.setText(riskScore(viewModel.weight26.value.toString()))
    }

    private fun riskScore(weight: String): String {
        if(weight == "1"){
            return "10"
        } else if (weight == "2"){
            return "8"
        } else if (weight == "3"){
            return "5"
        } else if (weight == "4"){
            return "2"
        } else if (weight == "5"){
            return "1"
        }
        return "0"
    }



    private fun createPdf() {
        try {
            val filename = "Autodiagnostico.pdf"
            //Document Settings
            val document = Document(PageSize.A4)
            document.addCreationDate()
            document.addAuthor("Beleza Legal")
            document.addCreator("Beleza Legal")


            val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                .toString()
            val dir = File(path, filename)
            if (!dir.exists()) {
                dir.parentFile.mkdirs()
            }
            val fOut = FileOutputStream(dir)
            fOut.flush()
            PdfWriter.getInstance(document, fOut)
            document.open()

            // Creating title
            val titleFont = Font(Font.FontFamily.HELVETICA,56f,Font.BOLDITALIC)
            val title = Paragraph(" Beleza Legal auto diagnostico ",titleFont)
            title.alignment = Paragraph.ALIGN_CENTER
            title.spacingAfter = 24f

            //creating table
            val font = Font(Font.FontFamily.HELVETICA, 16f)
            val columnWidth = floatArrayOf(80f, 20f)
            val table = PdfPTable(columnWidth)
            table.widthPercentage = 100f
            table.paddingTop = 24f
            table.spacingAfter = 24f



            // first row
            val cell1 = PdfPCell(Paragraph("Pergunta"))

            cell1.backgroundColor = BaseColor.GRAY


            // first row
            val cell2 = PdfPCell(Paragraph("Peso"))
            cell2.backgroundColor = BaseColor.GRAY


            val question1 = PdfPCell(Phrase(resources.getString(R.string.question1), font))
            val question2 = PdfPCell(Phrase(resources.getString(R.string.question2), font))
            val question3 = PdfPCell(Phrase(resources.getString(R.string.question3), font))
            val question4 = PdfPCell(Phrase(resources.getString(R.string.question4), font))
            val question5 = PdfPCell(Phrase(resources.getString(R.string.question5), font))
            val question6 = PdfPCell(Phrase(resources.getString(R.string.question6), font))
            val question7 = PdfPCell(Phrase(resources.getString(R.string.question7), font))
            val question8 = PdfPCell(Phrase(resources.getString(R.string.question8), font))
            val question9 = PdfPCell(Phrase(resources.getString(R.string.question9), font))
            val question10 = PdfPCell(Phrase(resources.getString(R.string.question10), font))
            val question11 = PdfPCell(Phrase(resources.getString(R.string.question11), font))
            val question12 = PdfPCell(Phrase(resources.getString(R.string.question12), font))
            val question13 = PdfPCell(Phrase(resources.getString(R.string.question13), font))
            val question14 = PdfPCell(Phrase(resources.getString(R.string.question14), font))
            val question15 = PdfPCell(Phrase(resources.getString(R.string.question15), font))
            val question16 = PdfPCell(Phrase(resources.getString(R.string.question16), font))
            val question17 = PdfPCell(Phrase(resources.getString(R.string.question17), font))
            val question18 = PdfPCell(Phrase(resources.getString(R.string.question18), font))
            val question19 = PdfPCell(Phrase(resources.getString(R.string.question19), font))
            val question20 = PdfPCell(Phrase(resources.getString(R.string.question20), font))
            val question21 = PdfPCell(Phrase(resources.getString(R.string.question21), font))
            val question22 = PdfPCell(Phrase(resources.getString(R.string.question22), font))
            val question23 = PdfPCell(Phrase(resources.getString(R.string.question23), font))
            val question24 = PdfPCell(Phrase(resources.getString(R.string.question24), font))
            val question25 = PdfPCell(Phrase(resources.getString(R.string.question25), font))
            val question26 = PdfPCell(Phrase(resources.getString(R.string.question26), font))



            val weight1 = PdfPCell(Phrase(riskScore(viewModel.weight1.toString()), font))
            val weight2 = PdfPCell(Phrase(riskScore(viewModel.weight2.toString()), font))
            val weight3 = PdfPCell(Phrase(riskScore(viewModel.weight3.toString()), font))
            val weight4 = PdfPCell(Phrase(riskScore(viewModel.weight4.toString()), font))
            val weight5 = PdfPCell(Phrase(riskScore(viewModel.weight5.toString()), font))
            val weight6 = PdfPCell(Phrase(riskScore(viewModel.weight6.toString()), font))
            val weight7 = PdfPCell(Phrase(riskScore(viewModel.weight7.toString()), font))
            val weight8 = PdfPCell(Phrase(riskScore(viewModel.weight8.toString()), font))
            val weight9 = PdfPCell(Phrase(riskScore(viewModel.weight9.toString()), font))
            val weight10 = PdfPCell(Phrase(riskScore(viewModel.weight10.toString()), font))
            val weight11 = PdfPCell(Phrase(riskScore(viewModel.weight11.toString()), font))
            val weight12 = PdfPCell(Phrase(riskScore(viewModel.weight12.toString()), font))
            val weight13 = PdfPCell(Phrase(riskScore(viewModel.weight13.toString()), font))
            val weight14 = PdfPCell(Phrase(riskScore(viewModel.weight14.toString()), font))
            val weight15 = PdfPCell(Phrase(riskScore(viewModel.weight15.toString()), font))
            val weight16 = PdfPCell(Phrase(riskScore(viewModel.weight16.toString()), font))
            val weight17 = PdfPCell(Phrase(riskScore(viewModel.weight17.toString()), font))
            val weight18 = PdfPCell(Phrase(riskScore(viewModel.weight18.toString()), font))
            val weight19 = PdfPCell(Phrase(riskScore(viewModel.weight19.toString()), font))
            val weight20 = PdfPCell(Phrase(riskScore(viewModel.weight20.toString()), font))
            val weight21 = PdfPCell(Phrase(riskScore(viewModel.weight21.toString()), font))
            val weight22 = PdfPCell(Phrase(riskScore(viewModel.weight22.toString()), font))
            val weight23 = PdfPCell(Phrase(riskScore(viewModel.weight23.toString()), font))
            val weight24 = PdfPCell(Phrase(riskScore(viewModel.weight24.toString()), font))
            val weight25 = PdfPCell(Phrase(riskScore(viewModel.weight25.toString()), font))
            val weight26 = PdfPCell(Phrase(riskScore(viewModel.weight26.toString()), font))


            table.addCell(cell1)
            table.addCell(cell2)
            table.addCell(question8)
            table.addCell(weight8)
            table.addCell(question9)
            table.addCell(weight9)
            table.addCell(question10)
            table.addCell(weight10)
            table.addCell(question11)
            table.addCell(weight11)
            table.addCell(question12)
            table.addCell(weight12)
            table.addCell(question13)
            table.addCell(weight13)
            table.addCell(question14)
            table.addCell(weight14)
            table.addCell(question15)
            table.addCell(weight15)
            table.addCell(question16)
            table.addCell(weight16)
            table.addCell(question17)
            table.addCell(weight17)
            table.addCell(question18)
            table.addCell(weight18)
            table.addCell(question19)
            table.addCell(weight19)
            table.addCell(question20)
            table.addCell(weight20)
            table.addCell(question21)
            table.addCell(weight21)
            table.addCell(question22)
            table.addCell(weight22)
            table.addCell(question23)
            table.addCell(weight23)
            table.addCell(question24)
            table.addCell(weight24)
            table.addCell(question25)
            table.addCell(weight25)
            table.addCell(question26)
            table.addCell(weight26)

            document.add(title)
            document.add(table)

            document.close()
        } catch (e: DocumentException) {
            e.printStackTrace()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            //document.close()
        }
    }


    private fun convertViewToPdf(){
        val view = binding.rootLayout
        view.measure(800,400)
        view.layout(0,0,800,400)

        // Create a new PdfDocument instance
        val document = PdfDocument()

        // Obtain the width and height of the view
        val viewWidth = view.measuredWidth
        val viewHeight = view.measuredHeight

        // Create a PageInfo object specifying the page attributes
        val pageInfo = PdfDocument.PageInfo.Builder(viewWidth, viewHeight, 1).create()

        // Start a new page
        val page = document.startPage(pageInfo)


        // Get the Canvas object to draw on the page
        val canvas = page.canvas


        // Create a Paint object for styling the view
        val paint = Paint()
        paint.color = Color.WHITE

        // Draw the view on the canvas
        view.draw(canvas)

        // Finish the page
        document.finishPage(page)


        // Specify the path and filename of the output PDF file
        val downloadsDir: File =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        val fileName = "autodiagnostico.pdf"
        val filePath = File(downloadsDir, fileName)

        try {
            // Save the document to a file
            val fos = FileOutputStream(filePath)
            document.writeTo(fos)
            document.close()
            fos.close()
            // PDF conversion successful
            Toast.makeText(context, "PDF Creation Successful", Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            e.printStackTrace()
            // Error occurred while converting to PDF
        }
    }
}