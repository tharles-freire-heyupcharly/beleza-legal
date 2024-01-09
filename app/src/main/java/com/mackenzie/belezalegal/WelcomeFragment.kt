package com.mackenzie.belezalegal


import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
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
import com.mackenzie.belezalegal.databinding.FragmentWelcomeBinding
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WelcomeFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var _binding: FragmentWelcomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        criandoPdf()

        binding.buttonNext.setOnClickListener {
            //findNavController().navigate(R.id.action_welcomeFragment_to_handoutFragment)
            findNavController().navigate(R.id.action_welcomeFragment_to_introductionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun criandoPdf() {
        try {
            val filename = "teste.pdf"
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
            val logo = Drawable.createFromPath(R.drawable.logo_beleza_legal.toString())

            val fOut = FileOutputStream(dir)
            fOut.flush()
            PdfWriter.getInstance(document, fOut)
            document.open()

            // Creating title
            val titleFont = Font(Font.FontFamily.HELVETICA,64f,Font.BOLD)
            val title = Paragraph(" Beleza Legal",titleFont)
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
            val weight1 = PdfPCell(Phrase("weight"))

            val weight8 = PdfPCell(Phrase("weight"))
            val weight9 = PdfPCell(Phrase("weight"))
            val weight10 = PdfPCell(Phrase("weight"))
            val weight11 = PdfPCell(Phrase("weight"))
            val weight12 = PdfPCell(Phrase("weight"))
            val weight13 = PdfPCell(Phrase("weight"))
            val weight14 = PdfPCell(Phrase("weight"))
            val weight15 = PdfPCell(Phrase("weight"))
            val weight16 = PdfPCell(Phrase("weight"))
            val weight17 = PdfPCell(Phrase("weight"))
            val weight18 = PdfPCell(Phrase("weight"))
            val weight19 = PdfPCell(Phrase("weight"))
            val weight20 = PdfPCell(Phrase("weight"))
            val weight21 = PdfPCell(Phrase("weight"))
            val weight22 = PdfPCell(Phrase("weight"))
            val weight23 = PdfPCell(Phrase("weight"))
            val weight24 = PdfPCell(Phrase("weight"))
            val weight25 = PdfPCell(Phrase("weight"))
            val weight26 = PdfPCell(Phrase("weight"))


            table.addCell(cell1)
            table.addCell(cell2)
            table.addCell(question8)
            table.addCell(weight1)
            table.addCell(question9)
            table.addCell(weight1)
            table.addCell(question10)
            table.addCell(weight1)
            table.addCell(question11)
            table.addCell(weight1)
            table.addCell(question12)
            table.addCell(weight1)
            table.addCell(question13)
            table.addCell(weight1)
            table.addCell(question14)
            table.addCell(weight1)
            table.addCell(question15)
            table.addCell(weight1)
            table.addCell(question16)
            table.addCell(weight1)
            table.addCell(question17)
            table.addCell(weight1)
            table.addCell(question18)
            table.addCell(weight1)
            table.addCell(question19)
            table.addCell(weight1)
            table.addCell(question20)
            table.addCell(weight1)
            table.addCell(question21)
            table.addCell(weight1)
            table.addCell(question22)
            table.addCell(weight1)
            table.addCell(question23)
            table.addCell(weight1)
            table.addCell(question24)
            table.addCell(weight1)
            table.addCell(question25)
            table.addCell(weight1)
            table.addCell(question26)
            table.addCell(weight1)

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






}